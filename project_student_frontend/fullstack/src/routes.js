import AddPage from "./pages/Add.vue";
import Home from "./pages/Home.vue";
import UpdatePage from "./pages/Update.vue";

export default[
    {
        path: "/",
        component: Home
    },
    {
        path: "/add",
        component: AddPage,
        name: 'Add'
    },
    {
        path: "/update/:id",
        component: UpdatePage,
        name: 'Update'
    }
]