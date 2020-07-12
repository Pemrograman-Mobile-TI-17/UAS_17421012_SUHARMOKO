const helm = require('../model/Helm.js')
const response = require('../config/response')
const mongoose = require('mongoose')
const ObjectId = mongoose.Types.ObjectId
exports.inputDatahelm = (data, gambar) =>
    new Promise(async (resolve, reject) =>{

        const helmBaru = new helm({
            kodeHelm : data.kodeHelm,
            tipeHelm : data.tipeHelm,
            jenisHelm: data.jenisHelm,
            merkHelm: data.merkHelm,
            hargaHelm: data.hargaHelm,
            gambar: gambar
        })

        await helm.findOne({kodeGitar: data.kodeHelm})
            .then(helm =>{
                if (helm){
                    reject(response.commonErrorMsg('Kode Gitar Sudah Digunakan'))
                }else{
                    helmBaru.save()
                        .then(r =>{
                            resolve(response.commonSuccessMsg('Berhasil Menginput Data'))
                        }).catch(err =>{
                        reject(response.commonErrorMsg('Mohon Maaf Input Gitar Gagal'))
                    })
                }
            }).catch(err =>{
                reject(response.commonErrorMsg('Mohon Maaf Terjadi Kesalahan Pada Server kami'))
            })
    })

exports.lihatDatahelm = () =>
    new Promise(async (resolve, reject) =>{
        await helm.find({})
            .then(result =>{
                resolve(response.commonResult(result))
            })
            .catch(()=>reject(response.commonErrorMsg('Mohon Maaf Terjadi Kesalahan Pada Server kami')))
    })

exports.lihatDetailDatahelm = (kodeHelm) =>
    new Promise(async (resolve, reject) =>{
        await helm.findOne({kodeHelm: kodeHelm})
            .then(result =>{
                resolve(response.commonResult(result))
            })
            .catch(()=>reject(response.commonErrorMsg('Mohon Maaf Terjadi Kesalahan Pada Server kami')))
    })

exports.updatehelm = (id, data, gambar) =>
    new Promise(async (resolve, reject)=>{
        await helm.updateOne(
            {_id : ObjectId(id)},
            {
                $set: {
                    kodeHelm : data.kodeHelm,
                    tipeHelm : data.tipeHelm,
                    jenisHelm: data.jenisHelm,
                    merkHelm: data.merkHelm,
                    hargaHelm: data.hargaHelm,
                    gambar: gambar
                }
            }
        ).then(b =>{
            resolve(response.commonSuccessMsg('Berhasil Mengubah Data'))
        }).catch(err =>{
            reject(response.commonErrorMsg('Mohon Maaf Terjadi Kesalahan Pada Server kami'))
        })
    })

exports.hapushelm = (_id) =>
    new Promise(async (resolve, reject) =>{
        await helm.remove({_id: ObjectId(_id)})
            .then(() =>{
                resolve(response.commonSuccessMsg('Berhasil Menghapus Data'))
            }).catch(() =>{
                reject(response.commonErrorMsg('Mohon Maaf Terjadi Kesalahan Pada Server kami'))
            })
    })