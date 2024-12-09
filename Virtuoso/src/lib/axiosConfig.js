import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080',
  // This header is used to skip the ngrok browser warning
  headers: {'ngrok-skip-browser-warning': 'true'},
});

export default instance;