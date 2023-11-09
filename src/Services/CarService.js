import axios from "axios";

const AddCarDetailsUrl = `http://localhost:8070/Cars/addCarDetails`;
const UpdateCarDetailsUrl = (carNumber) => `http://localhost:8070/Cars/updateCarDetails/${carNumber}`;
const GetCarByCarNumberUrl = (carNumber) => `http://localhost:8070/Cars/getByCarNumber/${carNumber}`;
const GetAllCarsUrl = `http://localhost:8070/Cars/allCars`;
const GetCarByWonerEmailUrl = (email) => `http://localhost:8070/Cars/getAllCarsByEmail/${email}`;

class CarService {
    addCarDetails(carDetails) {
        return axios.post(AddCarDetailsUrl, carDetails);
    }

    updateCarDetails(carNumber, carDetails) {
        const url = UpdateCarDetailsUrl(carNumber);
        return axios.put(url, carDetails);
    }

    getByCarNumber(carNumber) {
        const url = GetCarByCarNumberUrl(carNumber);
        return axios.get(url);
    }

    getAllCars() {
        return axios.get(GetAllCarsUrl);
    }

    getCarsByEmail(email)
    {
        const url = GetCarByWonerEmailUrl(email);
        return axios.get(url);
    }
}

export default new CarService();
