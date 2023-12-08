import concurrent.futures
import datetime
import random
from uuid import uuid4

"""
日期，用户ID，SessionID，页面ID,动作时间，搜索关键字，点击品类ID，点击产品ID，下单品类ID，下单产品ID，支付品类ID，支付产品ID，城市ID

"""


def fake_data():
    def fake_date():
        yr = random.randint(1990, 2023)
        mth = str(random.randint(1, 12)).zfill(2)
        day = str(random.randint(1, 30)).zfill(2)

        return f"{yr}-{mth}-{day}"

    def fake_user_id():
        return int(random.random() * 1000000)

    def fake_session_id():
        return uuid4()

    def fake_page_id():
        return random.randint(1, 10000)

    def fake_key_word():
        keys = ['鞋柜', '手电筒', '鞋拔子', '换血凳子', '沙发', '电视', '投影仪', '茶台', '衣架', '花瓶', '鲜花',
                '假花',
                '遥控器', '空调', '净化器', '大提琴', '小号', '锅', '碗', '瓢', '盆', '调料', '零食', '洗衣机', '冰箱',
                '净水器', '热水器', '烧水壶', '电饭煲', '汤煲', '床', '床垫', '手机', '电脑', '音像', '键盘', '椅子',
                '烟灰缸', '床头柜', '花盆', '喷壶', '餐桌']

        return random.choice(keys)

    def fake_action_time():
        hr = str(random.randint(0, 23)).zfill(2)
        mm = str(random.randint(0, 59)).zfill(2)
        ss = str(random.randint(0, 59)).zfill(2)

        return f"{fake_date()} {hr}:{mm}:{ss}"

    def fake_click_category():
        return random.randint(1, 100)

    def fake_click_product():
        return random.randint(1, 100)

    def fake_order_category():
        return f"{random.randint(1, 15)}-{random.randint(1, 100)}-{random.randint(1, 100)}"

    def fake_order_product():
        return f"{random.randint(1, 15)}-{random.randint(1, 100)}-{random.randint(1, 100)}"

    def fake_pay_category():
        return f"{random.randint(1, 15)}-{random.randint(1, 100)}-{random.randint(1, 100)}"

    def fake_pay_product():
        return f"{random.randint(1, 15)}-{random.randint(1, 100)}-{random.randint(1, 100)}"

    def fake_city_id():
        return random.randint(1, 36 * 20)

    seed = random.choice([2, 2, 2, 2, 2, 3, 3, 3, 5, 7])

    # print(seed, seed % 2, seed % 3, seed % 5, seed % 7)

    """
    日期，用户ID，SessionID，页面ID,动作时间，搜索关键字，点击品类ID，点击产品ID，下单品类ID，下单产品ID，支付品类ID，支付产品ID，城市ID
    """
    if seed % 2 == 0:
        return f"{fake_date()}_{fake_user_id()}_{fake_session_id()}_{fake_page_id()}_{fake_action_time()}_{fake_key_word()}_null_null_null_null_null_null_{fake_city_id()}\n"
    elif seed % 3 == 0:
        return f"{fake_date()}_{fake_user_id()}_{fake_session_id()}_{fake_page_id()}_{fake_action_time()}_null_{fake_click_category()}_{fake_click_product()}_null_null__null_null_{fake_city_id()}\n"
    elif seed % 5 == 0:
        return f"{fake_date()}_{fake_user_id()}_{fake_session_id()}_{fake_page_id()}_{fake_action_time()}_null_null_null_{fake_order_category()}_{fake_order_product()}_null_null_{fake_city_id()}\n"
    elif seed % 7 == 0:
        return f"{fake_date()}_{fake_user_id()}_{fake_session_id()}_{fake_page_id()}_{fake_action_time()}_null_null_null_null_null_{fake_pay_category()}_{fake_pay_product()}_{fake_city_id()}\n"


if __name__ == '__main__':
    cnt = 0
    with open('fake_user_visit_action.txt', 'w+', encoding='utf-8') as f:
        for j in range(1, 999999999):
            f.write(fake_data())
            if cnt % 100000 == 0:
                print("{:,}".format(cnt))
            cnt += 1
