import {createRouter, createWebHashHistory} from "vue-router";
import HomePage from "@/components/WelcomeComponent.vue";
import PageNotFound from "@/components/UnknownRoute.vue";
import GamePage31 from "@/components/games/GamesOverview31.vue";
import GamePage32 from "@/components/games/GamesOverview32.vue";
import GamePage33 from "@/components/games/GamesOverview33.vue";
import GamePage34 from "@/components/games/GamesOverview34.vue";
import GamePage37 from "@/components/games/GamesOverview37.vue";
import Detail32 from "@/components/games/Detail32.vue";
import Detail34 from "@/components/games/Detail34";
import Detail37 from "@/components/games/Detail37";

export const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        { path: '/', component: HomePage },
        { path: '/home', redirect: '/' },
        { path: '/games/overview31', component: GamePage31 },
        { path: '/games/overview32', component: GamePage32 },
        { path: '/games/overview33', component: GamePage33, children: [
                {path: ':id', component: Detail32, props: true}
            ]
        },
        {path: '/games/overview34', component: GamePage34, children: [
                {path: ':id', component: Detail34, props: true}
            ]
        },
        {path: '/games/overview37', component: GamePage37, children: [
                {path: ':id', component: Detail37, props: true}
            ]
        },

        {path: '/:pathMatch(.*)*', name:'pageNotFound', component: PageNotFound},

    ]
})