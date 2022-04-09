import {
    CHANGE_COUNTRY,
    CHANGE_DESCRIPTION,
    CHANGE_NAME,
    CHANGE_PRICE
} from "./productActions";

const initialState = {
    name: '',
    description: '',
    price: null,
    country: ''
};

export default (state = initialState, action) => {
    switch (action.type) {
        case CHANGE_PRICE:
            return {
                ...state,
                price: action.payload
            };
        default:
            return state;
    }
}