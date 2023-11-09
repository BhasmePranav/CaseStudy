import axios from "axios";

const generateLoginUrl = (email, password) => `http://localhost:8070/Customers/loginCustomer/${email}/${password}`;
const generateFindByEmailUrl = (email) => `http://localhost:8070/Customers/byEmail/${email}`;
const generateDeleteUrl = (email) => `http://localhost:8070/Customers/delete/${email}`;

class CustomerService {
    registerCustomer(customer) {
        return axios.post(`http://localhost:8070/Customers/register`, customer);
    }

    updateCustomer(customer) {
        return axios.put(`http://localhost:8070/Customers/update`, customer);
    }

    deleteCustomer(email) {
        const url = generateDeleteUrl(email);
        return axios.delete(url, { data: { email } });
    }

    displayAllCustomers() {
        return axios.get(`http://localhost:8070/Customers/allCustomers`);
    }

    getByEmail(email) {
        const url = generateFindByEmailUrl(email);
        return axios.get(url);
    }

    loginCustomer(email, password) {
        const url = generateLoginUrl(email, password);
        return axios.get(url);
    }
}

export default new CustomerService();
