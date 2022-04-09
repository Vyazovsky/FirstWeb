import {createStore, applyMiddleware, compose} from 'redux'
import thunk from 'redux-thunk'
import createRootReducer from './reducer'
import {createBrowserHistory} from "history";
import { routerMiddleware } from 'connected-react-router';

export const history = createBrowserHistory();

const initialState = {};
const enhancers = [];
const middleware = [
    routerMiddleware(history),
    thunk
];

export const noopStateToProps = () => ({})
export const noopDispatchToProps = () => ({})

if (process.env.NODE_ENV === 'development') {
    const devToolsExtension = window.__REDUX_DEVTOOLS_EXTENSION__;

    if (typeof devToolsExtension === 'function') {
        enhancers.push(devToolsExtension())
    }
}

export const composedEnhancers = compose(
    applyMiddleware(...middleware),
    ...enhancers
);

const store = createStore(
    createRootReducer(history),
    initialState,
    composedEnhancers
);

export default store;