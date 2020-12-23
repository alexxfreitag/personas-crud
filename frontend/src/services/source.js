import request from '../common/request';

class SourceService {

  get() {
    return request.get('/source');
  }
}

export default new SourceService();