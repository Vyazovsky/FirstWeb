import React from "react";
import {connect} from "react-redux";
import {Route, Switch} from "react-router-dom";
import Product from "./product/Product";
import ProductItem from "./product/ProductItem";

function AppComponent() {
    return(
        <div>
            <Switch>
                <Route path={'/'} exact component={Product}/>
                <Route path={'/:userId'} exact component={ProductItem}/>
            </Switch>
        </div>
    )
}

export default connect()(AppComponent);