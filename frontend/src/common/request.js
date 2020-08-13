import axios from 'axios'

const service = axios.create({
	baseURL: 'http://localhost:9090',
	timeout: 10000,
})

service.interceptors.request.use(
	config => {
		const token = Buffer.from(`admin:123456`, 'utf8').toString('base64');
		config.headers['Authorization'] = `Basic ${token}`
    return config
	},
	error => Promise.reject(error),
)

service.interceptors.response.use(
	response => {
		const res = response
		if (res.status === 401 || res.status === 403) {
      console.log("usuario nao autorizado");
			//UserLoginStore.logout()
		} else {
			return res.data
		}
	},
	error => Promise.reject(error),
)

export default service
