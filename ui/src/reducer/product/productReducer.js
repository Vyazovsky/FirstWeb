import {
    CHANGE_COUNTRY,
    CHANGE_DESCRIPTION,
    CHANGE_NAME,
    CHANGE_PRICE,
    CHANGE_PRODUCT
} from "./productActions";

const initialState = {
    name: '',
    description: '',
    price: '',
    country: '',
    products: []
};

export default (state = initialState, action) => {
    switch (action.type) {
        case CHANGE_PRICE:
            return {
                ...state,
                price: action.payload
            };
        case CHANGE_PRODUCT:
            return {
                ...state,
                products: action.payload
            };
        default:
            return state;
    }
}