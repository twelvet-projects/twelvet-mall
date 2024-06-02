import math
import random
from concurrent.futures import ThreadPoolExecutor
from datetime import datetime

import pymysql
from faker import Faker

# MySQL 连接配置
db_config = {
    'host': 'twelvet-mysql',
    'user': 'root',
    'password': '123456',
    'database': 'twelvet_mall_goods'
}

# 使用线程数量，自动计算插入千万数据
max_workers = 10

# 创建 MySQL 连接
conn = pymysql.connect(**db_config)
cursor = conn.cursor()

# 使用 Faker 生成模拟数据
fake = Faker()


# 获取国家下发货仓库编码
def generate_warehouse(country):
    if country == "US":
        return "US-" + random.choice(["WEST", "EAST", "MIDDLE", "SOUTH", "NORTH"]) + "-0" + str(
            random.choice([1, 2, 3, 4, 5]))
    else:
        return country + "00" + str(random.choice([1, 2, 3, 4, 5]))


sql = """INSERT INTO t_order (
            order_no,
            customer_no,
            order_status,
            warehouse_code,
            country,
            state,
            city,
            street,
            zip_code,
            contact_email,
            contact_name,
            contact_mobile,
            create_time,
            update_time,
            deleted
            ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"""


# 插入 t_order 表数据
def insert_data_thread(thread_id):
    # 创建 MySQL 连接
    conn = pymysql.connect(**db_config)
    cursor = conn.cursor()

    # 数据列表
    data = []
    # 循环总数
    range_count = math.ceil(10000000 / max_workers)
    for _ in range(range_count):
        order_no = "OC" + fake.uuid4()[:12]  # 取前16位
        customer_no = fake.uuid4()[:16]
        order_status = random.choice([1, 2, 3, 4, 5])
        country = random.choice(
            ["CA", "US", "MX", "JP", "UK", "TR", "DE", "ES", "FR", "IT", "NL", "PL", "SE", "BR", "CN"])
        warehouse_code = generate_warehouse(country)
        state = fake.uuid4()[:16]
        city = fake.uuid4()[:16]
        street = fake.uuid4()
        zip_code = fake.uuid4()[:6]
        contact_email = fake.email()
        contact_name = fake.name()
        contact_mobile = fake.phone_number()
        create_time = fake.date_time_between(start_date=datetime(2019, 1, 1), end_date=datetime.now())
        update_time = create_time
        deleted = 0  # 默认未删除

        # 插入数据
        data.append((order_no, customer_no, order_status, warehouse_code, country,
                     state, city, street, zip_code, contact_email, contact_name,
                     contact_mobile, create_time, update_time, deleted))
        data_count = len(data)
        print(str(thread_id) + "当前数据：" + str(data_count))
        if data_count >= 100:
            cursor.executemany(sql, data)
            # 提交 t_order 数据插入
            conn.commit()
            print(str(thread_id) + "插入数据1000条")
            data.clear()

    if len(data) != 0:
        cursor.executemany(sql, data)
        # 提交 t_order 数据插入
        conn.commit()
        data.clear()

    print(str(thread_id) + "完成数据插入")
    # 关闭数据库连接
    cursor.close()
    conn.close()


# 使用 ThreadPoolExecutor 并发插入
with ThreadPoolExecutor(max_workers=max_workers) as executor:  # 可以根据需要调整最大线程数
    futures = [executor.submit(insert_data_thread, i) for i in range(max_workers)]
    for future in futures:
        future.result()
