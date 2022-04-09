export const ADD_PRODUCT = 'productActions/ADD_PRODUCT';
export const CHANGE_NAME = 'productActions/CHANGE_NAME';
export const CHANGE_PRICE = 'productActions/CHANGE_PRICE';
export const CHANGE_DESCRIPTION = 'productActions/CHANGE_DESCRIPTION';
export const CHANGE_COUNTRY = 'productActions/CHANGE_COUNTRY';

export const changePrice = price => ({type: CHANGE_PRICE, payload: price});
