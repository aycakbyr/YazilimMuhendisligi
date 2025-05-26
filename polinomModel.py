#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed May 21 21:02:47 2025

@author: ayca
"""

import numpy as np
import matplotlib.pyplot as plt

# 1. Giriş verisi: t aralığı
t = np.linspace(-2, 2, 50)

# 2. Gerçek x değeri ve tanh modeli
x_true = 1.5
x= -0.5
def model(x, t):  # tanh modeli
    return np.tanh(x * t)

# 3. Gürültülü y verisi
np.random.seed(42)
noise = np.random.normal(0, 0.05, len(t))
y = model(x_true, t) + noise

# 4. Hata fonksiyonu
def error(x):
    return y - model(x, t)

# 5. Jacobian fonksiyonu: ∂e/∂x = -t * (1 - tanh^2(x * t))
def jacobian(x):
    tanh_val = np.tanh(x * t)
    return -t * (1 - tanh_val**2)

# 6. LM algoritması
x = 0.1                   # başlangıç tahmini
lambda_reg = 1e-3
max_iter = 100

for i in range(max_iter):
    e = error(x)
    J = jacobian(x).reshape(-1, 1)     # (n,1)
    H = J.T @ J + lambda_reg           # (1,1)
    g = J.T @ e.reshape(-1, 1)         # (1,1)
    dx = np.linalg.inv(H) @ g         # (1,1)
    
    x_new = x - dx.item()
    if abs(x_new - x) < 1e-6:
        break
    x = x_new

print("Bulunan x parametresi:", round(x, 4))

# 7. Görselleştirme
plt.figure(figsize=(8, 5))
plt.plot(t, y, 'ro', label='Gürültülü Veri')
plt.plot(t, model(x_true, t), 'g-', label='Gerçek Model')
plt.plot(t, model(x, t), 'b--', label='LM ile Uyumlu Model')
plt.xlabel("t")
plt.ylabel("y")
plt.legend()
plt.title("Hiperbolik Model - LM ile Uyum")
plt.grid(True)
plt.show()