import React from "react";
import {connect} from "react-redux";
import {changePrice, getProductsByPrice} from "../../reducer/product/productActions";
import ProductList from "./ProductList";

function Product({changePrice, price, getProductsByPrice}) {
    return (
        <div>
            <div>
                <label>Price:</label>
                <input value={price} onChange={({target: {value}}) => changePrice(value)}/>
            </div>
            <div>
                <input type={'button'} value={'Get By Price'} onClick={() => getProductsByPrice()}/>
            </div>

            <ProductList />
        </div>
    )
}

const mapStateToProps = ({product}) => {
    return product;
};

const mapDispatchToProps = {changePrice, getProductsByPrice};

export default connect(mapStateToProps, mapDispatchToProps)(Product);