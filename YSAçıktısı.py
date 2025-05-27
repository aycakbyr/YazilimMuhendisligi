#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed May 21 21:35:26 2025

@author: ayca
"""

import numpy as np

# Aktivasyon fonksiyonu (sigmoid)
def sigmoid(x):
    return 1 / (1 + np.exp(-x))

# Giriş verisi
x1, x2 = 0.5, 1.0

# Ağırlıklar ve biaslar
w11, w12 = 0.3, 0.5
w21, w22 = -0.4, 0.2
b1, b2 = 0.1, -0.2

w31, w32 = 0.7, -0.6
b3 = 0.05

# Gizli katman hesaplamaları
z1_input = w11 * x1 + w12 * x2 + b1
z2_input = w21 * x1 + w22 * x2 + b2

z1 = sigmoid(z1_input)
z2 = sigmoid(z2_input)

# Çıkış katmanı
output_input = w31 * z1 + w32 * z2 + b3
output = sigmoid(output_input)

# Sonuç
print("YSA Çıktısı:", output)