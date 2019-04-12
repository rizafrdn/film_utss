package com.example.rizaferdiyanita.film_uts_riza.models;

public class Daftar {
        private String id;
        private String title;
        private String desc;
        private String img;
        private int img_local;

        public Daftar(String id, String title, String desc, String img) {
            this.id = id;
            this.title = title;
            this.desc = desc;
            this.img = img;
        }
        public Daftar(String id, String title, String desc, int img_local) {
            this.id = id;
            this.title = title;
            this.desc = desc;
            this.img_local = img_local;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getImg_local() {
            return img_local;
        }

        public void setImg_local(int img_local) {
            this.img_local = img_local;
        }

    }

