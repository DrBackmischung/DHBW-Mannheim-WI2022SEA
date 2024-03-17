import { Box } from "@mui/material";
import "./FooterBar.scss"

function FooterBar() {
    return (
        <div className="impressum">
            <p className="impressum-text">
                <Box 
                    sx={{
                    justifyContent: "space-evenly",
                    flexGrow: 1,
                    display: { xs: "flex" },
                    }}
                >
                    <div>
                        <a href="www.google.de" className="impressum">Impressum</a> | <a href="www.google.de" className="impressum">Kontakt</a> | <a href="www.google.de" className="impressum">Facebook</a> | <a href="www.google.de" className="impressum">Instagram</a>
                    </div>
                </Box>
            </p>
        </div>    
    )
}

export default FooterBar;