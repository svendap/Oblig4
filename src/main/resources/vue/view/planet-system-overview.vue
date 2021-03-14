<template id="planet-system-overview">
   <div>
        <ul class="planet-system-overview-list">
            <li v-for="planetSystem in planetSystems">
                <a :href="`/planet-system/${planetSystem.name.trim()}`" class="link-to-planet-system-details">
                    <div class="single-planet-system-container" >
                        <h1>{{planetSystem.name}}</h1>

                        <img v-if="planetSystem.pictureUrl" class="cover-image-frontpage" v-bind:src="planetSystem.pictureUrl">
                        <img v-else class="cover-image-frontpage" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
                    </div>
                </a>
            </li>
        </ul>
   </div>
</template>
<script>
    Vue.component("planet-system-overview", {
        template: "#planet-system-overview",
        data: () => ({
            planetSystems: [],
        }),
        created() {
            fetch("/api/planet-system")
                .then(res => res.json())
                .then(res => {
                   this.planetSystems = res;
                })
                .catch(() => alert("Error while fetching planetsystems"));
        }
    });
</script>
<style>
    li{
        list-style-type: none;
    }

    .planet-system-overview-list{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    .planet-system-overview-list li{
        padding: 10px;
        border: 1px solid white;
        border-radius: 15px;
    }

    .link-to-planet-system-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color: white;
    }

    div.single-planet-system-container{
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    div.single-planet-system-container:hover{
        opacity: 1.0;
        overflow: hidden;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.cover-image-frontpage {
        height: auto;
        width: 100%;
        padding-bottom: 20px;
        max-height: 280px;
    }

</style>