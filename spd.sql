PGDMP                 
        z            spd    14.4    14.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394    spd    DATABASE     f   CREATE DATABASE spd WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Indonesian_Indonesia.1252';
    DROP DATABASE spd;
                postgres    false            �            1259    16400 	   aktivitas    TABLE     �   CREATE TABLE public.aktivitas (
    id_aktivitas character varying(5) NOT NULL,
    aktivitas_deskripsi character(100) NOT NULL
);
    DROP TABLE public.aktivitas;
       public         heap    postgres    false            �            1259    16395    anggota    TABLE     �   CREATE TABLE public.anggota (
    id_anggota numeric NOT NULL,
    nama_anggota character varying(50) NOT NULL,
    alamat character varying(100) NOT NULL,
    tanggal_lahir date NOT NULL
);
    DROP TABLE public.anggota;
       public         heap    postgres    false            �            1259    16405 	   transaksi    TABLE     I  CREATE TABLE public.transaksi (
    id_transaksi character varying(100) NOT NULL,
    id_anggota numeric NOT NULL,
    id_aktivitas character varying(20) NOT NULL,
    tanggal_transaksi timestamp without time zone NOT NULL,
    jumlah_transaksi numeric(100,0) NOT NULL,
    saldo numeric(100,0) NOT NULL,
    pinjaman numeric
);
    DROP TABLE public.transaksi;
       public         heap    postgres    false            �          0    16400 	   aktivitas 
   TABLE DATA           F   COPY public.aktivitas (id_aktivitas, aktivitas_deskripsi) FROM stdin;
    public          postgres    false    210   �       �          0    16395    anggota 
   TABLE DATA           R   COPY public.anggota (id_anggota, nama_anggota, alamat, tanggal_lahir) FROM stdin;
    public          postgres    false    209          �          0    16405 	   transaksi 
   TABLE DATA           �   COPY public.transaksi (id_transaksi, id_anggota, id_aktivitas, tanggal_transaksi, jumlah_transaksi, saldo, pinjaman) FROM stdin;
    public          postgres    false    211   �       f           2606    16404    aktivitas aktifitas_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.aktivitas
    ADD CONSTRAINT aktifitas_pkey PRIMARY KEY (id_aktivitas);
 B   ALTER TABLE ONLY public.aktivitas DROP CONSTRAINT aktifitas_pkey;
       public            postgres    false    210            d           2606    16409    anggota anggota_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.anggota
    ADD CONSTRAINT anggota_pkey PRIMARY KEY (id_anggota);
 >   ALTER TABLE ONLY public.anggota DROP CONSTRAINT anggota_pkey;
       public            postgres    false    209            �   A   x�+.)�N-�/R�-�*)��I,�̦�EyY���yY��4�);)��;57)1'����qqq a>�      �   �   x���
�0Dϛ���l�S���
"�Ћ����f�i(����a�7���G��j������	�)p�7No���s��hC���O��}���q�M��\���g�J*�s�2�l�he�(��%�\�!q��ۋ���c55�x��R?lM/y      �   �   x�m�A�0���
>`��4�-�8R@���"�T"K�FZS��Cb/��dI���������`�Lb�2m�[E�2��y{:DH�%�vЈ�Z5u�v��%����Tb_ط@/Lc{*M�}�Ss�<�.Mr�+k���r!| =\F7     