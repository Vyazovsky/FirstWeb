import React, {useState} from "react";
import {connect} from "react-redux";
import {getProductsByPrice} from "../../reducer/product/productActions";
import ProductList from "./ProductList";
import './Product.css'

function Product({getProductsByPrice}) {

    const[price, changePrice] = useState('');

    return (
        <div>
            <div>
                <label>Price:</label>
                <input value={price} onChange={({target: {value}}) => changePrice(value)}/>
            </div>
            <div>
                <input type={'button'} value={'Get By Price'} onClick={() => getProductsByPrice(price)}/>
            </div>

            <ProductList />
        </div>
    )
}

const mapStateToProps = ({product}) => {
    return product;
};

const mapDispatchToProps = {getProductsByPrice};

export default connect(mapStateToProps, mapDispatchToProps)(Product);