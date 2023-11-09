import axios from "axios";

const generateRegisterUrl = () => `http://localhost:8051/Admins/register`;
const generateUpdateUrl = () => `http://localhost:8051/Admins/updateAdmin`;
const generateDeleteUrl = (email) => `http://localhost:8051/Admins/deleteAdmin/${email}`;
const generateGetAllUrl = () => `http://localhost:8051/Admins/getAllAdmins`;
const generateLoginUrl = (email, password) =>`http://localhost:8051/Admins/loginAdmin/${email}/${password}`;

class AdminService {
  registerAdmin(admin) {
    const url = generateRegisterUrl();
    return axios.post(url, admin);
  }

  updateAdmin(admin) {
    const url = generateUpdateUrl();
    return axios.put(url, admin);
  }

  deleteAdmin(email) {
    const url = generateDeleteUrl(email);
    return axios.delete(url);
  }

  getAllAdmins() {
    const url = generateGetAllUrl();
    return axios.get(url);
  }

  loginAdmin(email, password) {
    const url = generateLoginUrl(email, password);
    return axios.get(url);
  }
}

export default new AdminService();
