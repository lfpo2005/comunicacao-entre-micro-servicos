import bcrypt from "bcrypt";
import User from "../../modules/user/model/User.js";

export async function createInitialData(){
    try {
        await User.sync({force: true});

        let pass = await bcrypt.hash("197197", 10);

        await User.create({
            name: "lfpo2005",
            email: "lfpo2005@yahoo.com.br",
            password: pass
        });
    } catch (err){
        console.log(err)

    }
}
