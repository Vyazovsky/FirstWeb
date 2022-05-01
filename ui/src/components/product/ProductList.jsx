import React, {useEffect} from "react";
import {connect} from "react-redux";
import {getAllProducts} from "../../reducer/product/productActions";

import './ProductList.css';
import {Link} from "react-router-dom";

function ProductList({getAllProducts, products}) {

    useEffect(() => {
        getAllProducts();
    }, [])

    return (
        <div>
            <table>
                <thead>
                <th>Name</th>
                <th>Price</th>
                </thead>
                <tbody>
                {products.map(product => <tr key={product.id}>
                    <Link to={`/${product.id}`}>
                        <td>{product.name}</td>
                    </Link>
                    <td>{product.actualPrice} <span className={'old-price'}>{product.price}</span></td>
                </tr>)}
                </tbody>
            </table>
        </div>
    )
}

const mapStateToProps = ({product: {products}}) => {
    return {products};
};

const mapDispatchToProps = {getAllProducts};

export default connect(mapStateToProps, mapDispatchToProps)(ProductList);