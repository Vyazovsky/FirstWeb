import axios from 'axios';
import product from "./productReducer";

export const ADD_PRODUCT = 'productActions/ADD_PRODUCT';
export const CHANGE_NAME = 'productActions/CHANGE_NAME';
export const CHANGE_PRICE = 'productActions/CHANGE_PRICE';
export const CHANGE_DESCRIPTION = 'productActions/CHANGE_DESCRIPTION';
export const CHANGE_COUNTRY = 'productActions/CHANGE_COUNTRY';
export const CHANGE_PRODUCT = 'productActions/CHANGE_PRODUCT';

export const changePrice = price => ({type: CHANGE_PRICE, payload: price});
export const changeProducts = products => ({type: CHANGE_PRODUCT, payload: products})

export const getProductsByPrice = () => (dispatch, getState) => {
    const {price} = getState().product;
    axios.get(`http://localhost:8082/api/product/get-by-price/${price}`)
        .then(response => {
            if(response.status === 200) {
                dispatch(changeProducts(response.data));
            }
        })
};

export const getAllProducts = () => (dispatch, getState) => {
    axios.get('http://localhost:8082/api/product')
        .then((response) => {
            if(response.status === 200) {
                dispatch(changeProducts(response.data));
            }
        })
};
