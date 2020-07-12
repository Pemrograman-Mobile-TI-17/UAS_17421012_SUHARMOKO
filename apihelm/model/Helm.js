const mongoose = require('mongoose');

const userSchema = mongoose.Schema({

    kodeHelm: {
        type: String
    },
    tipeHelm: {
        type: String
    },
    jenisHelm: {
        type: String
    },
    merkHelm: {
        type: String
    },
    hargaHelm: {
        type: String
    },
    gambar: {
        type: String
    }
})
module.exports = mongoose.model('helm', userSchema)