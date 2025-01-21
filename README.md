# Selenium Project to Automate Test API and Web 

### README : Automation Test API dan Web Menggunakan Cucumber, Java, Gradle, dan Selenium

#### **Deskripsi Proyek**
Proyek ini adalah kerangka kerja untuk testing automation UI Web dan API menggunakan **Rest-Assured**, **Cucumber**, **Java**, **Gradle**, dan **Selenium**. 
Dengan menerapkan pola **Page Object Model (POM)** untuk memisahkan logika eksekusi case dari testing. 

#### **Fitur**
- Penulisan skenario uji berbasis Gherkin (bahasa alami).
- Dukungan pengujian positif, negatif, dan batasan.
- Integrasi Selenium WebDriver untuk pengujian browser otomatis.
- Pembuatan laporan uji otomatis dalam format HTML.

#### **Persyaratan**
- **Java**: Versi 11 atau lebih baru.
- **Gradle**: Versi 7 atau lebih baru.
- Browser (Chrome) dan **WebDriverManager**.

#### **Cara Menjalankan Testing**
1. Clone repositori ini:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Jalankan semua pengujian:
   - `API Test`
   ```bash
   ./gradlew apirun
   ```
   
   - `WEB Test`
   ```bash
   ./gradlew webrun
   ```
3. Lihat laporan hasil pengujian untuk `API` 
di folder `project\reports\api` 
dan jika untuk `WEB` di folder `project\reports\api`.

#### **Teknologi yang Digunakan**
- **Java**
- **Gradle**
- **Rest-Assured**
- **Cucumber**
- **Selenium**
- **WebDriverManager**
