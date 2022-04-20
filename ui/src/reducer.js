import {combineReducers} from "redux";
import product from "./reducer/product/productReducer";
import {connectRouter} from "connected-react-router";

export default (history) => combineReducers({
   router: connectRouter(history),
   product
});