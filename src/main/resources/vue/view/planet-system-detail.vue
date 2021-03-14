<template id="planet-system-detail">
    <div class="content-wrapper">
        <div v-if="planetSystem" class="detail-planet-system-container">
          <!--img v-if="planetSystem.pictureUrl" class="cover-image" v-bind:src="planetSystem.pictureUrl">
          <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png"-->

          <img v-if="planetSystem.centerStar.pictureUrl" class="cover-image" v-bind:src="planetSystem.centerStar.pictureUrl">
          <img v-else class="cover-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">


          {{console.log(this.planetSystem)}}

            <h1>{{planetSystem.name}}</h1>
            <p>The {{planetSystem.name}} has {{planets.length}} planets revolving around the star {{star.name}}.</p>
        </div>

        <ul id="sortList">
            <li><a v-if="sorting" :href="`/planet-system/${planetSystem.name}?sort_by=name`">Sort alphabetically</a></li>
            <li><a v-if="sorting" :href="`/planet-system/${planetSystem.name}?sort_by=mass`">Sort by mass</a></li>
            <li><a v-if="sorting" :href="`/planet-system/${planetSystem.name}?sort_by=num`">Sort by number</a></li>
            <li><a v-if="sorting" :href="`/planet-system/${planetSystem.name}?sort_by=radius`">Sort by radius</a></li>
        </ul>

        <ul class="planet-overview-list">
            <li v-for="planet in planets">
                <a v-if="planetSystem" class="link-to-planet-details" :href="`/planet-system/${planetSystem.name}/planets/${planet.name}`">
                    <div class="single-planet-container" >
                        <h1>{{planet.name}}</h1>
                        <img v-if="planet.pictureUrl" class="list-image" v-bind:src="planet.pictureUrl">
                        <img v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
                    </div>
                </a>
            </li>
        </ul>
    </div>
</template>
<script>
    Vue.component("planet-system-detail", {
        template: "#planet-system-detail",
        data: () => ({
            planetSystem: null,
            planets: [],
            star: null,
            sorting: "name",
        }),
        created() {
            const planetSystemId = this.$javalin.pathParams["planet-system-id"];
            var sort = this.$javalin.queryParams["sort_by"];
            if (typeof sort != 'undefined')
                this.sorting = sort;
            fetch(`/api/planet-system/${planetSystemId}`)
                .then(res => res.json())
                .then(res => {
                    this.planetSystem = res
                    this.star = this.planetSystem.centerStar
                })
                .catch(() => alert("Error while fetching planet system"))
            fetch(`/api/planet-system/${planetSystemId}/planets?sort_by=${this.sorting}`)
                .then(res => res.json())
                .then(res => this.planets = res)
                .catch(() => alert("Error while fetching planets"));
        }
    });
</script>
<style>

    .planet-overview-list{
        color:black;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;

    }

    #sortList{
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        margin-top: 30px;
        margin-bottom: 30px;
    }

    #sortList li{
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    #sortList li a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    #sortList li:hover{
        border: 2px solid white;
    }

    div.detail-planet-system-container{
        padding: 10px;
        overflow: hidden;
        width: 750px;
        margin: 0 auto;
        background-color: rgba(20, 20, 20, 0.98);
        opacity: 0.96;
        color: white;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    div.single-planet-container{
        overflow: hidden;
        color: white;
        background-color: rgba(0, 0, 0, 0.98);
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    .single-star-container{
        height:100px;
        width:40%;
        background-color: #F0FFFF;
        opacity: 0.96;
        text-align: center;
        margin-left: 34%;
    }


    div.single-star-container:hover{
        height:115px;
        opacity:1.0;

    }

    img.cover-image {
        height: auto;
        width: 50%;
        margin: 5px;
        float: left;
    }

    img.list-image {
        width: 140px;
        padding-bottom: 20px;
        transition: transform .2s;
    }

   .list-image:hover{
       transform: scale(1.1);
   }

    h1{
        font-size:18px;
        padding-top: 10px;
    }

    .link-to-planet-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color:black;
    }

    .button {
        padding: 10px;
        margin: 10px;
        border: 1px solid white;
        color: white;
        border-radius: 15px;
    }

    button a{
        color: white;
        text-decoration: none;
        font-weight: bold;
    }

    .button:hover{
        border: 2px solid white;
    }

</style>
