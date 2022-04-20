import React, {useEffect} from "react";
import {connect} from "react-redux";
import {getAllProducts} from "../../reducer/product/productActions";

import './ProductList.css';

function ProductList ({getAllProducts, products}) {

    useEffect(() => {
        getAllProducts();
    }, [])

    return(
        <div>
            <table>
                <thead>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Country</th>
                </thead>
                <tbody>
                {products.map(product => <tr>
                    <td>{product.name}</td>
                    <td>{product.price}</td>
                    <td>{product.description}</td>
                    <td>{product.country}</td>
                </tr>)}
                </tbody>
            </table>
        </div>
    )
}

const mapStateToProps = ({product:{products}}) => {
    return {products};
};

const mapDispatchToProps = {getAllProducts};

export default connect(mapStateToProps, mapDispatchToProps)(ProductList);