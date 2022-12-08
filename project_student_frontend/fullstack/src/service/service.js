import http from "@/http-common";

class studentService {
  create(data) {
    return http.post("/shipping/insert", data);
  }

  getAll() {
    return http.get("/shipping/getAll");
  }

  deleteStudents(id) {
    return http.delete(`/shipping/delete/${id}`);
  }

  updateStudents(id, data) {
    return http.put(`/shipping/update/${id}`, data);
  }
  getStudent(id) {
    return http.get(`/shipping/student/${id}`);
  }
}

export default new studentService();
