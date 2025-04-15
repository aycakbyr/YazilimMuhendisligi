import numpy as np
import matplotlib.pyplot as plt
from tabulate import tabulate

def golden_section_optimization(func_str, a, b, delta_x_son=0.0001, max_iter=100):
    """
    Altın Bölme yöntemiyle fonksiyonun minimumunu bulma.
    
    Parametreler:
        func_str: Fonksiyon ifadesi (string)
        a: Alt sınır
        b: Üst sınır
        delta_x_son: Son değişim değeri (durma kriteri)
        max_iter: Maksimum iterasyon sayısı
    """
    # Altın oran
    tau = (np.sqrt(5) - 1) / 2  # yaklaşık 0.618034
    
    # Maksimum iterasyon sayısını hesapla
    N = int(-2.078 * np.log(delta_x_son / (b - a)))
    
    print(f"Altın Bölme Yöntemi ile Optimizasyon")
    print(f"Fonksiyon: f(x) = {func_str}")
    print(f"Arama aralığı: [{a}, {b}]")
    print(f"Durma kriteri (Δx_son): {delta_x_son}")
    print(f"Altın oran (τ): {tau:.6f}")
    print(f"Maksimum iterasyon sayısı (N): {N}")
    
    # Fonksiyonu oluştur
    f = eval(f"lambda x: {func_str}")
    
    # İterasyon sonuçları için liste
    iterations = []
    
    # İlk iç noktaları hesapla
    x1 = a + (1 - tau) * (b - a)
    x2 = a + tau * (b - a)
    
    # Fonksiyon değerlerini hesapla
    f1 = f(x1)
    f2 = f(x2)
    
    # Başlangıç değerlerini kaydet
    iterations.append([0, x1, x2, f1, f2])
    
    print(f"\nBaşlangıç değerleri:")
    print(f"  x1: {x1:.4f}, f(x1): {f1:.4f}")
    print(f"  x2: {x2:.4f}, f(x2): {f2:.4f}")
    
    # İterasyon
    k = 1
    while k <= min(N, max_iter):
        if f1 > f2:
            # x1'i x2 ve x2'yi yeni nokta ile değiştir
            a = x1
            x1 = x2
            f1 = f2
            x2 = a + tau * (b - a)
            f2 = f(x2)
        else:
            # x2'yi x1 ve x1'i yeni nokta ile değiştir
            b = x2
            x2 = x1
            f2 = f1
            x1 = a + (1 - tau) * (b - a)
            f1 = f(x1)
        
        # İterasyon sonuçlarını kaydet
        iterations.append([k, x1, x2, f1, f2])
        
        print(f"\nİterasyon {k}:")
        print(f"  x1: {x1:.4f}, f(x1): {f1:.4f}")
        print(f"  x2: {x2:.4f}, f(x2): {f2:.4f}")
        
        # Durma kriteri kontrolü
        if abs(b - a) < delta_x_son:
            print(f"\nYakınsama sağlandı: |b-a| = {abs(b-a):.6f} < {delta_x_son}")
            break
            
        k += 1
    
    # Optimum noktayı, aralığın ortası olarak kabul et
    x_opt = (a + b) / 2
    f_opt = f(x_opt)
    
    print(f"\nSonuç:")
    print(f"  Minimum nokta: x = {x_opt:.6f}")
    print(f"  Minimum değer: f(x) = {f_opt:.6f}")
    print(f"  İterasyon sayısı: {k}")
    
    # Tablo oluştur
    headers = ["k", "x1", "x2", "f(x1)", "f(x2)"]
    print("\nAltın Bölme İterasyonları:")
    print(tabulate(iterations, headers=headers, floatfmt=".4f", tablefmt="grid"))
    
    return x_opt, f_opt, iterations

def main():
    # Örnek problem
    func_str = "(x-1)**2 * (x-2) * (x-3)"
    a = 0 #alt deger
    b = 4 #ust deger
    delta_x_son = 0.0001 #(Δ𝑥)son = 0.0001 alınız.
    
    # Altın bölme optimizasyonu uygula
    x_opt, f_opt, iterations = golden_section_optimization(func_str, a, b, delta_x_son)
    
    # Fonksiyonu görselleştir
    x = np.linspace(0, 4, 1000)
    f = eval(f"lambda x: {func_str}")
    y = [f(xi) for xi in x]
    
    plt.figure(figsize=(10, 6))
    plt.plot(x, y, 'b-', label='f(x)')
    plt.plot(x_opt, f_opt, 'ro', label=f'Minimum ({x_opt:.4f}, {f_opt:.4f})')
    
    # İlk ve son iterasyondaki noktaları göster
    plt.plot([iterations[0][1], iterations[0][2]], [iterations[0][3], iterations[0][4]], 'go', label='İlk iterasyon')
    plt.plot([iterations[-1][1], iterations[-1][2]], [iterations[-1][3], iterations[-1][4]], 'mo', label='Son iterasyon')
    
    plt.grid(True)
    plt.legend()
    plt.title(f'Altın Bölme Optimizasyon: f(x) = {func_str}')
    plt.xlabel('x')
    plt.ylabel('f(x)')
    plt.show()

if __name__ == "__main__":
    main()