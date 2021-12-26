import Vue from 'vue';
import axios from "axios";

const ajax = axios.create({
    baseURL: 'http://localhost:7070'
});

Vue.prototype.$ajax = ajax;
