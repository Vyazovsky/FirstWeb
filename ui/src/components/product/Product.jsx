import React from "react";
import {connect} from "react-redux";
import {changePrice} from "../../reducer/product/productActions";

function Product({changePrice, price}) {
    return (
        <div>
            <div>
                <label>Price:</label>
                <input value={price} onChange={({target: {value}}) => changePrice(value)}/>
            </div>
            <div>
                <input type={'button'} value={'Create User'}/>
            </div>
        </div>
    )
}

const mapStateToProps = ({product}) => {
    return product;
};

const mapDispatchToProps = {changePrice};

export default connect(mapStateToProps, mapDispatchToProps)(Product);