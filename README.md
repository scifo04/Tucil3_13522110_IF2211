# Tugas Kecil 3 Strategi Algoritma IF2211 Penyelesaian Permainan Word Ladder Menggunakan Algoritma UCS, Greedy Best First Search, dan A*

> IF2211 Strategi Algoritma 2023/2024

## **Daftar Isi**

- [Deskripsi Program](#deskripsi-program)
- [Requirement Program](#requirements-program)
- [Set Up dan Build Program](#set-up-dan-build-program)
- [Home Page](#home-page)
- [Test](#test)
- [Author](#author)

## **Deskripsi Program**

<p align="justify">
Word ladder (juga dikenal sebagai Doublets, word-links, change-the-word puzzles, paragrams, laddergrams, atau word golf) adalah salah satu permainan kata yang terkenal bagi seluruh kalangan. Word ladder ditemukan oleh Lewis Carroll, seorang penulis dan matematikawan, pada tahun 1877. Pada permainan ini, pemain diberikan dua kata yang disebut sebagai start word dan end word. Untuk memenangkan permainan, pemain harus menemukan rantai kata yang dapat menghubungkan antara start word dan end word. Banyaknya huruf pada start word dan end word selalu sama. Tiap kata yang berdekatan dalam rantai kata tersebut hanya boleh berbeda satu huruf saja. Pada permainan ini, diharapkan solusi optimal, yaitu solusi yang meminimalkan banyaknya kata yang dimasukkan pada rantai kata.

Repository ini berisi implementasi dalam mencari solusi terdekat dari sebuah permainan Word Ladder dan membandingkan ketiga algoritma UCS, Greedy Best First Search, dan A*

</p>

## **Requirements Program**
Program ini membutuhkan Java setidaknya versi 20.0.2

## **Set Up dan Build Program**
1. Download file .zip
2. Buka terminal dan pergi ke direktori root aplikasi 
     ```bash
     ./Tucil3_13522110_IF2211
     ```
3. Untuk buka program masukkan perintah:
     ```bash
     ./run.bat
     ``` 
4. Atau langsung buka lewat java
     ```bash
     cd src
     java Main
     ```
5. Program sudah siap untuk digunakan

## **Home Page**
<p align="center">
<img src="test/MainPage.png">
</p>

## **Cara Menggunakan Program** ##
1. Masukkan input dari kata pertama
2. Masukkan input dari kata tujuan
3. Pilih metode antara algoritma UCS, GBFS, dan A*
4. Klik tombol "Submit"
5. Tunggu beberapa saat agar solusi bisa terlihat

## **Test**
<p align="center">

Input algoritma UCS:

<img src="test/UCS_in1.png">

Output algoritma UCS:

<img src="test/UCS_out1.png">

Input algoritma GBFS:

<img src="test/GBFS_in2.png">

Output algoritma GBFS:

<img src="test/GBFS_out2.png">

Input algoritma A*:

<img src="test/AStar_in3.png">

Output algoritma A*:

<img src="test/AStar_out3.png">
</p>

## **Author**

|   NIM    |           Nama           |
| :------: | :----------------------: |
| 13522110 | Marvin Scifo Y. Hutahaean  |


<!-- Optional -->
<!-- ## License -->
<!-- This project is open source and available under the [... License](). -->

<!-- You don't have to include all sections - just the one's relevant to your project -->
