#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed May 21 21:19:42 2025

@author: ayca
"""

import numpy as np
import matplotlib.pyplot as plt
import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.optimizers import Adam

# Veri seti
t_train = np.linspace(-10, 10, 40).reshape(-1, 1)
y_train = np.sinc(t_train / np.pi)  # sin(x)/x = sinc(x/pi)

# Model tanımı
model = Sequential()
model.add(Dense(6, input_dim=1, activation='tanh'))  # Gizli katman
model.add(Dense(1, activation='linear'))  # Çıkış katmanı

# Derleme
model.compile(optimizer=Adam(learning_rate=0.01), loss='mse')

# Eğitim
history = model.fit(t_train, y_train, epochs=500, verbose=0)

# Tahmin için daha yoğun veri
t_dense = np.linspace(-10, 10, 200).reshape(-1, 1)
y_pred = model.predict(t_dense)

# Gerçek değerler (referans için)
y_true = np.sinc(t_dense / np.pi)

# Grafik 1: Model çıktısı ve gerçek değer
plt.figure(figsize=(10, 5))

plt.subplot(1, 2, 1)
plt.plot(t_dense, y_true, label="sin(x)/x", color='black')
plt.plot(t_dense, y_pred, label="model", linestyle='--', color='orange')
plt.scatter(t_train, y_train, label="eğitim verisi", color='green')
plt.xlabel("t")
plt.ylabel("y")
plt.legend()
plt.title("Model vs Gerçek Fonksiyon")

# Grafik 2: Eğitim Hatası (log MSE)
plt.subplot(1, 2, 2)
plt.plot(np.log10(history.history['loss']), color='blue')
plt.xlabel("İterasyon")
plt.ylabel("log(MSE)")
plt.title("Eğitim Hatası")

plt.tight_layout()
plt.show()