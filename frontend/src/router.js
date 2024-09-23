
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReservationReserveManager from "./components/listers/ReservationReserveCards"
import ReservationReserveDetail from "./components/listers/ReservationReserveDetail"

import TicketTicketManager from "./components/listers/TicketTicketCards"
import TicketTicketDetail from "./components/listers/TicketTicketDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reservations/reserves',
                name: 'ReservationReserveManager',
                component: ReservationReserveManager
            },
            {
                path: '/reservations/reserves/:id',
                name: 'ReservationReserveDetail',
                component: ReservationReserveDetail
            },

            {
                path: '/tickets/tickets',
                name: 'TicketTicketManager',
                component: TicketTicketManager
            },
            {
                path: '/tickets/tickets/:id',
                name: 'TicketTicketDetail',
                component: TicketTicketDetail
            },



    ]
})
