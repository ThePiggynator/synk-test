import {createRouter, createWebHashHistory} from "vue-router";
import HomePage from "@/components/WelcomeComponent.vue";
import PageNotFound from "@/components/UnknownRoute.vue";
import GamePage31 from "@/components/games/GamesOverview31.vue";
import GamePage32 from "@/components/games/GamesOverview32.vue";
import GamePage33 from "@/components/games/GamesOverview33.vue";
import Detail32 from "@/components/games/Detail32.vue";

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


        {path: '/:pathMatch(.*)*', name:'pageNotFound', component: PageNotFound},

    ]
})