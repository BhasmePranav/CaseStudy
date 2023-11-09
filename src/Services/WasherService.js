import axios from "axios";

const generateLoginUrl = (email, password) => `http://localhost:8051/Washers/loginWasher/${email}/${password}`;
const generateDeleteUrl = (email) => `http://localhost:8051/Washers/delete/${email}`;
const getByEmail_Url = (email) => `http://localhost:8051/Washers/byEmail/${email}`;

class WasherService {
    registerWasher(washer) {
        return axios.post(`http://localhost:8051/Washers/register`, washer);
    }

    updateWasher(washer) {
        return axios.put(`http://localhost:8051/Washers/update`, washer);
    }

    deleteWasher(email) {
        const url = generateDeleteUrl(email);
        return axios.delete(url, { data: { email } });
    }

    getAllWashers() {
        return axios.get(`http://localhost:8051/Washers/allWashers`);
    }

    loginWasher(email, password) {
        const url = generateLoginUrl(email, password);
        return axios.get(url);
    }

    getByEmail(email)
    {
        const url = getByEmail_Url(email);
        return axios.get(url);
    }
}

export default new WasherService();
