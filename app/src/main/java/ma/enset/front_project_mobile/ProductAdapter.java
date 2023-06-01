package ma.enset.front_project_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<ProductItem> productList;

    public ProductAdapter(List<ProductItem> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductItem productItem = productList.get(position);
        holder.bind(productItem);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productNameTextView;
        private TextView productDescriptionTextView;
        private TextView productPriceTextView;
        private TextView productQuantityTextView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productImage);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            productDescriptionTextView = itemView.findViewById(R.id.productDescriptionTextView);
            productPriceTextView = itemView.findViewById(R.id.productPriceTextView);
            productQuantityTextView = itemView.findViewById(R.id.productQuantityTextView);
        }

        public void bind(ProductItem productItem) {
            productNameTextView.setText(productItem.getName());
            productDescriptionTextView.setText(productItem.getDescription());
            productPriceTextView.setText(String.format(Locale.getDefault(), "%.2f MAD", productItem.getPrice()));
            productQuantityTextView.setText("x" + productItem.getQuantity());

            productImage.setImageResource(productItem.getImageResource());
        }
    }
}
