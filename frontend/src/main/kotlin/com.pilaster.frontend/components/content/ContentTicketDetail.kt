package com.pilaster.frontend.components.content

import kotlinx.css.*
import kotlinx.html.js.onLoadFunction
import kotlinx.html.js.onMouseUpFunction
import kotlinx.html.onMouseUp
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h1
import react.dom.script
import react.dom.style
import styled.css
import styled.styledDiv

class ContentTicketDetail : RComponent<RProps, RState>() {

    override fun RBuilder.render() {


        h1 { +"TICKET DETAIL" }


        script {
            setProp("src", "")
        }
        styledDiv {
            setProp("id", "kanbanTest")
            attrs {
                onMouseUpFunction = {
                }
            }
            css {
                background = "red"
                height = 100.pct
                width = 100.pct
                position = Position.fixed
            }
            css {
            }
        }

        script {
            js("""
                        console.log('abc');
                        setTimeout(function() {
                        document.getElementById('kanbanTest').innerHTML = '';
                        console.log('def');
                            var test = new jKanban({
                    element: "#kanbanTest",
                    gutter: "10px",
                    widthBoard: "450px",
                    itemHandleOptions:{
                      enabled: true,
                    },
                    click: function(el) {
                      console.log("Trigger on all items click!");
                    },
                    boards: [
                      {
                        id: "_todo",
                        title: "To Do (Can drop item only in working)",
                        class: "info,good",
                        dragTo: ["_working"],
                        item: [
                          {
                            id: "_test_delete",
                            title: "Try drag this (Look the console)",
                            drag: function(el, source) {
                              console.log("START DRAG: " + el.dataset.eid);
                            },
                            dragend: function(el) {
                              console.log("END DRAG: " + el.dataset.eid);
                            },
                            drop: function(el) {
                              console.log("DROPPED: " + el.dataset.eid);
                            }
                          },
                          {
                            title: "Try Click This!",
                            click: function(el) {
                              alert("click");
                            },
                            class: ["peppe", "bello"]
                          }
                        ]
                      },
                      {
                        id: "_working",
                        title: "Working (Try drag me too)",
                        class: "warning",
                        item: [
                          {
                            title: "Do Something!"
                          },
                          {
                            title: "Run?"
                          }
                        ]
                      },
                      {
                        id: "_done",
                        title: "Done (Can drop item only in working)",
                        class: "success",
                        dragTo: ["_working"],
                        item: [
                          {
                            title: "All right"
                          },
                          {
                            title: "Ok!"
                          }
                        ]
                      }
                    ]
                  });                  
                        }, 0);
                        
                    """)
        }


    }
}