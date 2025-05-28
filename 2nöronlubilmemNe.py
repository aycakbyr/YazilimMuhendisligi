#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed May 28 21:09:34 2025

@author: ayca
"""
#2 nöronlu yapay sinşr agı 2 girişli problem kac tane bu tarz soru 
import numpy as np

def sigmoid(x):
    return 1 / (1 + np.exp(-x))

# Giriş verisi
X = np.array([[0.5, -0.7]])

# Ağırlıklar ve biaslar
W_input_hidden = np.array([[0.1, 0.4], [-0.3, 0.2]])
b_hidden = np.array([0.0, -0.1])
W_hidden_output = np.array([[0.5], [-0.6]])
b_output = np.array([0.05])

# İleri yayılım
hidden_input = np.dot(X, W_input_hidden) + b_hidden
hidden_output = sigmoid(hidden_input)
output_input = np.dot(hidden_output, W_hidden_output) + b_output
output = sigmoid(output_input)

# Parametre sayısı
total_weights = W_input_hidden.size + W_hidden_output.size
total_biases = b_hidden.size + b_output.size
total_params = total_weights + total_biases

# Çıktılar
print("Giriş:", X)
print("Gizli katman çıkışı:", hidden_output)
print("Çıkış:", output)
print("\nToplam öğrenilecek parametre sayısı:", total_params)
print("  - Ağırlık sayısı:", total_weights)
print("  - Bias sayısı:", total_biases)