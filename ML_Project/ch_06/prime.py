# -*- coding: utf-8 -*-
"""
@Time : 2017/6/2 - 15:50
@Auther : Hao Chen
1.求素数的代码设计以及比较
2.赔率的代码实现
"""

import numpy as np
from time import time
import math

def is_prime(x):
    return 0 not in [x % i for i in range(2, int(math.sqrt(x)) + 1)]
def is_prime3(x):
    flag = True
    for p in p_list2:
        if p > math.sqrt(x):
            break
        if x % p == 0:
            flag = False
            break
    if flag:
        p_list2.append(x)
    return flag
if __name__ == "__main__":
    a = 2
    b = 10000

    # 方法1：直接计算
    t = time()
    p = [p for p in range(a, b) if 0 not in [p % d for d in range(2, int(math.sqrt(p)) + 1)]]
    print time() - t
    print p

    # 方法2：利用filter
    t = time()
    p = filter(is_prime, range(a, b))
    print time() - t
    print p

    # 方法3：利用filter和lambda
    t = time()
    is_prime2 = (lambda x: 0 not in [x % i for i in range(2, int(math.sqrt(x)) + 1)])
    p = filter(is_prime2, range(a, b))
    print time() - t
    print p

    # 方法4：定义
    t = time()
    p_list = []
    for i in range(2, b):
        flag = True
        for p in p_list:
            if p > math.sqrt(i):
                break
            if i % p == 0:
                flag = False
                break
        if flag:
            p_list.append(i)
    print time() - t
    print p_list

    # 方法5：定义和filter
    p_list2 = []
    t = time()
    filter(is_prime3, range(2, b))
    print time() - t
    print p_list2

    print '------------------------------'
    a = 750
    b = 900
    p_list2 = []
    np.set_printoptions(linewidth=150)  # 每行显示的宽度
    p = np.array(filter(is_prime3, range(2, b + 1))) # 将输出结果保存在数字中
    p = p[p >= a] # 得到大于等于a的素数
    print p
    p_rate = float(len(p)) / float(b-a+1) # 求出a和b之间素数的比值
    print '素数的概率：', p_rate, '\n',
    print '公正赔率：', 1/p_rate,
    print '合数的概率：',1-p_rate, '\n',
    print '公正赔率：', 1 / (1-p_rate),

    alpha1 = 5.5 * p_rate
    alpha2 = 1.1 * (1 - p_rate)
    print '赔率系数：', alpha1, alpha2
    print 1 - (alpha1 + alpha2) / 2
    print (1 - alpha1) * p_rate + (1 - alpha2) * (1 - p_rate)
