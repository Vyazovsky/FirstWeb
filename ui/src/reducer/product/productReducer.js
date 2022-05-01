import {
    CHANGE_PRODUCT,
    SET_DETAIL_PRODUCT
} from "./productActions";

const initialState = {
    productDetails: {
        id: '',
        name: '',
        description: '',
        price: '',
        country: '',
        actualPrice: ''
    },
    products: []
};

export default (state = initialState, action) => {
    switch (action.type) {
        case SET_DETAIL_PRODUCT:
            return {
                ...state,
                productDetails: {...action.payload}
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