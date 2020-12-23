import request from '../common/request';

class UserService {

  getAll() {
    return request.get('/users');
  }

  register(data) {
    return request.post('/users', data);
  }

  delete(id) {
    return request.delete(`/users/${id}`);
  }

  update(id, data) {
    return request.put(`/users/${id}`, data);
  }
}

export default new UserService();