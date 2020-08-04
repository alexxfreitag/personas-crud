import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:9090',
});

/* api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('JWT_TOKEN') || '';
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error),
);

api.interceptors.response.use(
  (response) => {
    const res = response;
    if (res.status === 401 || res.status === 403) {
      console.log('usuario nao autorizado');
      // UserLoginStore.logout()
    } else {
      return res.data;
    }
  },
  (error) => Promise.reject(error),
); */

export default api;
