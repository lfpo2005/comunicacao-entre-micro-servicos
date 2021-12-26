import Sequelize from "sequelize";

const sequelize = new Sequelize("auth-db", "postgres", "admin",{
    host: "localhost",
    dialect: "postgres",
    quoteIdentifiers: false,
    define: {
        syncOnAssociation: true,
        timestamps: false,
        underscored: true,
        underscoredAll: true,
        freezeTableName: true
    }
});

sequelize
.authenticate()
.then(() =>{
    console.log("Connection has been established!");
})
.catch((err) =>{
    console.error("Unable to connect to the database!");
    console.error(err.message)
});

export default sequelize;