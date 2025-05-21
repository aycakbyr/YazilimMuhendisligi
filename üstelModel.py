#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed May 21 20:52:54 2025

@author: ayca
"""

import numpy as np
import matplotlib.pyplot as plt

# 1. Sabit rastgelelik (PDF'deki gibi olması için)
np.random.seed(42)

# 2. Giriş verisi: t ∈ [-4, 4] aralığında, 0.4 artımlı
t = np.arange(-4, 4.4, 0.4)

# 3. Gerçek parametrelerle model
x_true = np.array([0.6294, 0.8116])
def model_func(t, x):
    return x[0] * np.exp(x[1] * t)

# 4. Gürültülü gözlem oluştur
noise = np.random.normal(0, 0.02, size=len(t))  # Gauss gürültü
y_noisy = model_func(t, x_true) + noise

# 5. Hata fonksiyonu: e(x) = y - f(x)
def error(x):
    return y_noisy - model_func(t, x)

# 6. Jacobian matrisi (J)
def jacobian(x):
    J = np.zeros((len(t), 2))
    J[:, 0] = -np.exp(x[1] * t)
    J[:, 1] = -x[0] * t * np.exp(x[1] * t)
    return J

# 7. LM algoritması parametreleri
x = np.array([0.5, 0.5])  # Sabit başlangıç noktası (key part!)
lambda_reg = 1e-8
I = np.eye(2)
max_iter = 100

# 8. LM döngüsü
for i in range(max_iter):
    J = jacobian(x)
    e = error(x)
    update = np.linalg.inv(J.T @ J + lambda_reg * I) @ J.T @ e
    x = x - update
    if np.linalg.norm(update) < 1e-6:
        break

# 9. Sonuç
print("Bulunan parametreler:", np.round(x, 4))