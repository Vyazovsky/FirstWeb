import axios from 'axios';
import product from "./productReducer";

export const ADD_PRODUCT = 'productActions/ADD_PRODUCT';
export const CHANGE_PRODUCT = 'productActions/CHANGE_PRODUCT';
export const SET_DETAIL_PRODUCT = 'productActions/SET_DETAIL_PRODUCT';

export const changeProducts = products => ({type: CHANGE_PRODUCT, payload: products})

export const getProductsByPrice = (price) => (dispatch, getState) => {
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

export const getCustomerProductDetails = (id) => (dispatch) => {
  axios.get(`http://localhost:8082/api/product/get-by-id/${id}`)
      .then(response => {
          if(response.status === 200) {
              const {id, name, description, price, country, actualPrice} = response.data;
              dispatch({type: SET_DETAIL_PRODUCT, payload: {id, name, description, price, country, actualPrice}})
          }
      })
};
