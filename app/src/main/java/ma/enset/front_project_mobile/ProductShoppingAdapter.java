package ma.enset.front_project_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductShoppingAdapter extends RecyclerView.Adapter<ProductShoppingAdapter.ProductViewHolder>  {
    private List<ProductItem> productList;

    public ProductShoppingAdapter(List<ProductItem> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_item_cart, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductItem productItem = productList.get(position);

        holder.productImageView.setImageResource(productItem.getImageResource());
        holder.productNameTextView.setText(productItem.getName());
        holder.priceTextView.setText("$ " + productItem.getPrice());
        holder.quantityTextView.setText("x" + productItem.getQuantity());

        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQuantity = productItem.getQuantity();
                if (currentQuantity > 1) {
                    productItem.setQuantity(currentQuantity - 1);
                    notifyItemChanged(holder.getAdapterPosition());
                }
            }
        });

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQuantity = productItem.getQuantity();
                productItem.setQuantity(currentQuantity + 1);
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImageView;
        private TextView productNameTextView;
        private TextView priceTextView;
        private TextView quantityTextView;
        private Button minusButton;
        private Button plusButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.productImage);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            quantityTextView = itemView.findViewById(R.id.text_quantity);
            minusButton = itemView.findViewById(R.id.button_minus);
            plusButton = itemView.findViewById(R.id.button_plus);
        }
    }
}
